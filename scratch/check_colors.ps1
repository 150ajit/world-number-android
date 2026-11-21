Add-Type -AssemblyName System.Drawing
$c3Path = Join-Path $PSScriptRoot "..\play_store_assets\logo_candidates\candidate3_cyber_mesh.jpg"
$bmp = New-Object System.Drawing.Bitmap((Resolve-Path $c3Path).Path)

Write-Host "Top-Left (0,0):" $bmp.GetPixel(0, 0)
Write-Host "Top-Right (1023,0):" $bmp.GetPixel(1023, 0)
Write-Host "Bottom-Left (0,1023):" $bmp.GetPixel(0, 1023)
Write-Host "Bottom-Right (1023,1023):" $bmp.GetPixel(1023, 1023)
Write-Host "Top-Center (512, 10):" $bmp.GetPixel(512, 10)
Write-Host "Bottom-Center (512, 1013):" $bmp.GetPixel(512, 1013)

$bmp.Dispose()

