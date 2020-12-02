@echo off

echo.
echo                                      GitHub自动上传脚本
echo ===================================================================================
echo.

set /p change=请输入commit名：


git add .
git commit -m %change%
git push origin master

echo.
echo ===================================================================================
echo                                      更新完毕
echo.

pause