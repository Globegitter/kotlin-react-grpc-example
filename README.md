# kotlin-react-grpc-example

To start the backend run `./gradlew api:run` and to start the react app run `./gradlew app:yarn_run_start`, this will make a grpc request as soon as it is loaded up and there is a button to make a new request.

Note: When using Ctrl+C to terminate the react dev server gradle is forwarding the signal so you will unfortunately have to manually terminate the server. See: <https://github.com/srs/gradle-node-plugin/issues/339>
