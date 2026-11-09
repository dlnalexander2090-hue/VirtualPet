@echo off
title Practica Git - Parte 1
cd /d "%~dp0"
echo on
git config --global user.name
git config --global user.email
git status
git --no-pager log
git branch -M main
git remote add origin https://github.com/dlnalexander2090-hue/VirtualPet.git
git remote -v
git push -u origin main
@echo off
echo.
echo ===== PARTE 1 TERMINADA: NO CIERRES ESTA VENTANA =====
pause >nul
