@echo off
title Practica Git - Parte 1 (local)
cd /d "%~dp0"
echo on
git config --global user.name "Dylan Alexander Perez Perez"
git config --global user.email "dperezp2526@politecnics.barcelona"
git config --global --list
git init
git status
git add .
git status
git commit -m "feat: proyecto VirtualPet inicializado en local"
git --no-pager log
@echo off
echo.
echo ===== PARTE 1 LOCAL TERMINADA =====
pause
