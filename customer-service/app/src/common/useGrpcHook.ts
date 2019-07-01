import { useReducer, useRef, useEffect } from 'react';
import {HelloRequest, HelloReply} from '../grpc-web/helloworld_pb';

// Hook for gRPC queries
// TODO: Improve this whole hook for https://github.com/facebook/react/issues/14920 and for typescript
// TODO: See if we can do better than "any" or "HelloRequest"
export const useGrpcRequest = (request: (arg0: HelloRequest) => Promise<HelloReply>, variables: HelloRequest, initialData: Array<any>) => {
  const [state, dispatch] = useReducer(requestReducer, {
    isLoading: false,
    isError: false,
    data: initialData,
  });
  const mounted = useRef(true);

  // TODO: Fix support for newVariables
  const makeRequest = async (newVariables?: HelloRequest) => {
    dispatch({ type: 'REQUEST_START' });

    // const params = {
    //   ...variables,
    //   ...newVariables,
    // };

    try {
      const response = await request(variables);
      if (!mounted.current) return;
      dispatch({ type: 'REQUEST_SUCCESS', payload: response.toObject() });
    } catch (error) {
      if (!mounted.current) return;
      dispatch({ type: 'REQUEST_ERROR', payload: error });
    }
  };

  useEffect(() => {
    makeRequest();
    return () => {mounted.current = false};
  }, []);

  return [state.data, state.isError, state.isLoading, makeRequest];
};

const requestReducer = (state: any, action: any) => {
  switch (action.type) {
    case 'REQUEST_START':
      return {
        ...state,
        isLoading: true,
      };
    case 'REQUEST_SUCCESS':
      return {
        ...state,
        isLoading: false,
        isError: false,
        data: action.payload,
      };
    case 'REQUEST_ERROR':
      return {
        ...state,
        isLoading: false,
        isError: action.payload,
      };
    default:
      throw new Error();
  }
};
