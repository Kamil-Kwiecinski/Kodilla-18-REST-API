call runcrud.bat
if "%ERRORLEVEL%" == "0" goto startchrome
echo
echo There were errors
goto fail

:startchrome
start chrome http://localhost:8080/crud/v1/tasks/
if "%ERRORLEVEL%" == "0" goto end

:fail
echo.
echo Something went wrong, script failed

:end
echo.
echo Everything is fine, job done