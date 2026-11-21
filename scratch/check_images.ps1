Add-Type -AssemblyName System.Drawing
$iconPath = Join-Path $PSScriptRoot "..\play_store_assets\app_icon_512x512.png"
$c3Path = Join-Path $PSScriptRoot "..\play_store_assets\logo_candidates\candidate3_cyber_mesh.jpg"

$icon = [System.Drawing.Image]::FromFile((Resolve-Path $iconPath).Path)
Write-Host "app_icon: $($icon.Width) x $($icon.Height) pixel format: $($icon.PixelFormat)"
$icon.Dispose()

$c3 = [System.Drawing.Image]::FromFile((Resolve-Path $c3Path).Path)
Write-Host "candidate3: $($c3.Width) x $($c3.Height) pixel format: $($c3.PixelFormat)"
$c3.Dispose()

