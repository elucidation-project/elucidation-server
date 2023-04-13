# Elucidation Server

Simple base service that includes the elucidation bundle so that tracking service relationships can be started very quickly.

See https://github.com/elucidation-project/elucidation for details on the API.

# Docker
This project bundles up the service into a docker image. To run use the following to pull the image:

`docker pull kiwiproject/elucidation-server:latest`

Then to run the service run the following command:

`docker run -d -p 8080:8080 kiwiproject/elucidation-server:latest`

This will start the container and expose the service on port 8080.