import React, { useState, useContext } from 'react';
import * as grpcWeb from 'grpc-web';
import * as jspb from "google-protobuf"

import {HelloReply, HelloRequest} from './grpc-web/helloworld_pb';
import { useGrpcRequest } from './common/useGrpcHook';
import { ClientContext } from './index';
import logo from './logo.svg';
import './App.css';

const App: React.FC = () => {
  const greeterClient = useContext(ClientContext);
  const newHelloRequest = async (request: HelloRequest) => {
    return new Promise<HelloReply>((resolve, reject) => {
      greeterClient.sayHello(request, {}, (err, response: HelloReply) => {
        if (err) {
          if (err.code !== grpcWeb.StatusCode.OK) {
            reject(err)
            console.log(
                'Error code: ' + err.code + ' "' + err.message + '"');
          }
        } else {
          resolve(response)
        }
      })
    });
  };

  const request = new HelloRequest();
  request.setName("Markus");

  const [data, error, loading, refetch] = useGrpcRequest(newHelloRequest, request, []);

  const handleClick = () => refetch();

  if (error) {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <div>
            {loading ? <div>Retrying...</div> : <div>Error: {error.message}</div>}
            <button onClick={handleClick}>Retry</button>
          </div>
        </header>
      </div>
    );
  }

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Hello, my grpc service message is: {loading ? "loading..." : data.message}
        </p>
        <button onClick={handleClick}>Request again</button>
      </header>
    </div>
  );
}

export default App;

