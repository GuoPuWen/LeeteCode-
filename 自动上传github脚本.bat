@echo off

echo.
echo                                      GitHub自动上传脚本
echo ===================================================================================
echo.

set /p change=请输入commit名：
echo.
cd "你的项目地址路径"

git pull
git add .
git commit -m %change%
git push

echo.
echo ===================================================================================
echo                                      更新完毕
echo.

pause