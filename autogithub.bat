@echo off

echo.
echo                                      GitHub自动上传脚本
echo ===================================================================================
echo.




git add .
git commit 
git push origin master

echo.
echo ===================================================================================
echo                                      更新完毕
echo.

pause