# Project: Flaky Test & Coverage Coach in CI

## Deployment
- Firstly ensure that **Docker Desktop is running**
- To deploy this project run **startDocker.cmd** :
    - In console there will be logs from all running containers(*Only warnings and errors*)
    - Service is fully up aprrox. 30s after message about *Healthy* status of backend container
- To stop service run **stopDocker.cmd**
- To clear all volumes(**Warning:** *including maven dependencies and database files*) run **CLEARALL.cmd**


## API Reference

[Backend API Documentation](http://localhost:8082/swagger-ui/index.html "Swagger UI") - works only when project is fully running

