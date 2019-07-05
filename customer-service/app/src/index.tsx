import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';

// TODO: Should use GreeterPromiseClient but not yet supported in TS. See https://github.com/grpc/grpc-web/issues/580
import { GreeterClient } from './grpc-web/HelloworldServiceClientPb';

declare global {
  interface Window {
    __GRPCWEB_DEVTOOLS__: (arg0: Array<any>) => void;
  }
}

const enableDevTools = window.__GRPCWEB_DEVTOOLS__ || (() => {});

const client = new GreeterClient('http://localhost:8080');

enableDevTools([
  client,
]);

export const createDefaultClient = (): GreeterClient => client;

export const ClientContext = React.createContext<GreeterClient>(
  createDefaultClient()
); // Provide gRPC client in context

ReactDOM.render(
  <ClientContext.Provider value={client}>
    <App />
  </ClientContext.Provider>,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
