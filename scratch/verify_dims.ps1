Add-Type -AssemblyName System.Drawing
$png = [System.Drawing.Image]::FromFile((Resolve-Path "play_store_assets\feature_graphic_1024x500.png").Path)
Write-Host "PNG: $($png.Width)x$($png.Height)"
$png.Dispose()

$jpg = [System.Drawing.Image]::FromFile((Resolve-Path "play_store_assets\feature_graphic_1024x500.jpg").Path)
Write-Host "JPG: $($jpg.Width)x$($jpg.Height)"
$jpg.Dispose()

