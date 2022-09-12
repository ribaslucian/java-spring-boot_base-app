ECHO OFF

:: %1 Commit message. Default "Auto up by Lucian's script".
:: %2 Destiny branch. Default main.

git add .
git add -A

IF "%~1"=="" (
    git commit -m "Auto up by Lucian's script"
) ELSE (
    git commit -m %1
)

IF "%~2"=="" (
    git push origin %1
) ELSE (
    git push origin main
)
