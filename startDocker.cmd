@echo off
call docker-compose up --build
echo "--------------------Docker stopped working!--------------------"
echo .
echo "--------------------Calling docker-compose down--------------------"
call docker-compose down
echo "--------------------Containers are closed and removed safely--------------------"
pause