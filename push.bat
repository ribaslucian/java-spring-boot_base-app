ECHO OFF

git add .
git add -A

IF "%~1"=="" (
    git commit -m "Auto up by Lucian's script"
) ELSE (
    git commit -m %1
)

git push origin main