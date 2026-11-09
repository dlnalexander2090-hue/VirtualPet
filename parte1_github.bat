@echo off
title Practica Git - Parte 1 (subida a GitHub)
cd /d "%~dp0"
echo on
git branch -M main
git remote add origin https://github.com/dlnalexander2090-hue/VirtualPet.git
git remote -v
git push -u origin main
@echo off
echo.
echo ===== SUBIDA A GITHUB TERMINADA =====
pause
