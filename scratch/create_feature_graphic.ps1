Add-Type -AssemblyName System.Drawing

$srcIconPath = Join-Path $PSScriptRoot "..\play_store_assets\logo_candidates\candidate3_cyber_mesh.jpg"
$destPng = Join-Path $PSScriptRoot "..\play_store_assets\feature_graphic_1024x500.png"
$destJpg = Join-Path $PSScriptRoot "..\play_store_assets\feature_graphic_1024x500.jpg"

$width = 1024
$height = 500

$bmp = New-Object System.Drawing.Bitmap($width, $height, [System.Drawing.Imaging.PixelFormat]::Format32bppArgb)
$g = [System.Drawing.Graphics]::FromImage($bmp)
$g.SmoothingMode = [System.Drawing.Drawing2D.SmoothingMode]::HighQuality
$g.InterpolationMode = [System.Drawing.Drawing2D.InterpolationMode]::HighQualityBicubic
$g.PixelOffsetMode = [System.Drawing.Drawing2D.PixelOffsetMode]::HighQuality
$g.TextRenderingHint = [System.Drawing.Text.TextRenderingHint]::ClearTypeGridFit

# 1. Background Gradient: Deep Slate to Midnight Cyan
$bgRect = New-Object System.Drawing.Rectangle(0, 0, $width, $height)
$bgBrush = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
    (New-Object System.Drawing.Point(0, 0)),
    (New-Object System.Drawing.Point($width, $height)),
    [System.Drawing.Color]::FromArgb(255, 11, 17, 28),
    [System.Drawing.Color]::FromArgb(255, 15, 23, 42)
)
$g.FillRectangle($bgBrush, $bgRect)
$bgBrush.Dispose()

# Ambient radial glow behind the icon (Left side x=240, y=250)
for ($r = 280; $r -ge 60; $r -= 20) {
    $alpha = [int](18 * (1.0 - ($r / 280.0)))
    $glowBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb($alpha, 6, 182, 212))
    $g.FillEllipse($glowBrush, 240 - $r, 250 - $r, $r * 2, $r * 2)
    $glowBrush.Dispose()
}

# Ambient secondary emerald glow (lower right of icon)
for ($r = 200; $r -ge 50; $r -= 25) {
    $alpha = [int](14 * (1.0 - ($r / 200.0)))
    $glowBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb($alpha, 16, 185, 129))
    $g.FillEllipse($glowBrush, 320 - $r, 340 - $r, $r * 2, $r * 2)
    $glowBrush.Dispose()
}

# Subtle Tech Grid Pattern
$gridPen = New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(12, 148, 163, 184), 1)
for ($x = 0; $x -lt $width; $x += 48) {
    $g.DrawLine($gridPen, $x, 0, $x, $height)
}
for ($y = 0; $y -lt $height; $y += 48) {
    $g.DrawLine($gridPen, 0, $y, $width, $y)
}
$gridPen.Dispose()

# Faint telemetry crosshairs & accent dots
$accentPen = New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(40, 6, 182, 212), 1)
$g.DrawLine($accentPen, 48, 48, 64, 48)
$g.DrawLine($accentPen, 48, 48, 48, 64)
$g.DrawLine($accentPen, 976, 48, 960, 48)
$g.DrawLine($accentPen, 976, 48, 976, 64)
$g.DrawLine($accentPen, 48, 452, 64, 452)
$g.DrawLine($accentPen, 48, 452, 48, 436)
$g.DrawLine($accentPen, 976, 452, 960, 452)
$g.DrawLine($accentPen, 976, 452, 976, 436)
$accentPen.Dispose()

# Helper function to create rounded rectangle path
function Get-RoundRectPath($rect, $radius) {
    $path = New-Object System.Drawing.Drawing2D.GraphicsPath
    $d = $radius * 2
    $path.AddArc($rect.X, $rect.Y, $d, $d, 180, 90)
    $path.AddArc($rect.Right - $d, $rect.Y, $d, $d, 270, 90)
    $path.AddArc($rect.Right - $d, $rect.Bottom - $d, $d, $d, 0, 90)
    $path.AddArc($rect.X, $rect.Bottom - $d, $d, $d, 90, 90)
    $path.CloseFigure()
    return $path
}

# 2. Draw Candidate 3 App Icon (Exact Logo)
$iconSize = 330
$iconX = 75
$iconY = 85
$iconRect = New-Object System.Drawing.Rectangle($iconX, $iconY, $iconSize, $iconSize)

# Shadow behind the app icon card
for ($s = 16; $s -ge 2; $s -= 2) {
    $sAlpha = [int](8 * (1.0 - ($s / 16.0)))
    $sRect = New-Object System.Drawing.Rectangle($iconX - $s, $iconY - $s + 4, $iconSize + ($s * 2), $iconSize + ($s * 2))
    $sPath = Get-RoundRectPath $sRect (64 + $s)
    $sBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb($sAlpha, 0, 0, 0))
    $g.FillPath($sBrush, $sPath)
    $sBrush.Dispose()
    $sPath.Dispose()
}

# Load Candidate 3 source icon
$srcIcon = [System.Drawing.Image]::FromFile((Resolve-Path $srcIconPath).Path)

# Clip to rounded squircle
$iconPath = Get-RoundRectPath $iconRect 64
$state = $g.Save()
$g.SetClip($iconPath)
$g.DrawImage($srcIcon, $iconRect)
$g.Restore($state)

# Glass border for the icon card
$borderBrush = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
    (New-Object System.Drawing.Point($iconX, $iconY)),
    (New-Object System.Drawing.Point($iconX + $iconSize, $iconY + $iconSize)),
    [System.Drawing.Color]::FromArgb(180, 56, 189, 248),
    [System.Drawing.Color]::FromArgb(120, 16, 185, 129)
)
$borderPen = New-Object System.Drawing.Pen($borderBrush, 2.5)
$g.DrawPath($borderPen, $iconPath)
$borderPen.Dispose()
$borderBrush.Dispose()
$iconPath.Dispose()
$srcIcon.Dispose()

# 3. Typography & Right-Side Content
$contentX = 450

# Live Badge Pill
$pillX = $contentX
$pillY = 75
$pillW = 205
$pillH = 30
$pillRect = New-Object System.Drawing.Rectangle($pillX, $pillY, $pillW, $pillH)
$pillPath = Get-RoundRectPath $pillRect 15
$pillBg = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(180, 15, 30, 50))
$g.FillPath($pillBg, $pillPath)
$pillBorder = New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(100, 6, 182, 212), 1.2)
$g.DrawPath($pillBorder, $pillPath)
$pillBg.Dispose()
$pillBorder.Dispose()
$pillPath.Dispose()

# Green pulsing dot in pill
$dotBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(255, 16, 185, 129))
$g.FillEllipse($dotBrush, $pillX + 12, $pillY + 10, 10, 10)
$dotBrush.Dispose()

# Pill Text
$pillFont = New-Object System.Drawing.Font("Segoe UI", 9, [System.Drawing.FontStyle]::Bold)
$pillTextBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(255, 56, 189, 248))
$g.DrawString("LIVE DEMOGRAPHICS", $pillFont, $pillTextBrush, $pillX + 28, $pillY + 7)
$pillFont.Dispose()
$pillTextBrush.Dispose()

# Main Title: "WorldNumber"
$titleFont = New-Object System.Drawing.Font("Segoe UI", 44, [System.Drawing.FontStyle]::Bold)
$titleY = 118

# Measure "World"
$worldSize = $g.MeasureString("World", $titleFont)
$whiteBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(255, 255, 255, 255))
$g.DrawString("World", $titleFont, $whiteBrush, $contentX, $titleY)
$whiteBrush.Dispose()

# Gradient Brush for "Number"
$cyanBrush = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
    (New-Object System.Drawing.Point($contentX + [int]$worldSize.Width - 10, $titleY)),
    (New-Object System.Drawing.Point($contentX + [int]$worldSize.Width + 240, $titleY + 60)),
    [System.Drawing.Color]::FromArgb(255, 34, 211, 238),
    [System.Drawing.Color]::FromArgb(255, 52, 211, 153)
)
$g.DrawString("Number", $titleFont, $cyanBrush, $contentX + [int]$worldSize.Width - 14, $titleY)
$cyanBrush.Dispose()
$titleFont.Dispose()

# Tagline
$tagFont = New-Object System.Drawing.Font("Segoe UI", 15, [System.Drawing.FontStyle]::Regular)
$tagBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(255, 148, 163, 184))
$g.DrawString("Real-Time Global Population & Demographic Engine", $tagFont, $tagBrush, $contentX, 198)
$tagFont.Dispose()
$tagBrush.Dispose()

# Divider Line
$divPen = New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(60, 51, 65, 85), 1)
$g.DrawLine($divPen, $contentX, 238, 960, 238)
$divPen.Dispose()

# 4. Three Feature Cards
$features = @(
    @{ Stat = "8.14B+"; Label = "Real-Time Population Counter"; Color = [System.Drawing.Color]::FromArgb(255, 6, 182, 212) },
    @{ Stat = "195+";   Label = "Countries & Global Rankings";   Color = [System.Drawing.Color]::FromArgb(255, 16, 185, 129) },
    @{ Stat = "ms Sync"; Label = "Dynamic Timezone Calibration"; Color = [System.Drawing.Color]::FromArgb(255, 168, 85, 247) }
)

$cardY = 260
$cardW = 510
$cardH = 60
$statFont = New-Object System.Drawing.Font("Segoe UI", 15, [System.Drawing.FontStyle]::Bold)
$labelFont = New-Object System.Drawing.Font("Segoe UI", 11, [System.Drawing.FontStyle]::Regular)

for ($i = 0; $i -lt $features.Count; $i++) {
    $f = $features[$i]
    $cy = $cardY + ($i * 70)
    $cRect = New-Object System.Drawing.Rectangle($contentX, $cy, $cardW, 60)
    $cPath = Get-RoundRectPath $cRect 12
    
    # Card Background
    $cBg = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(120, 20, 30, 48))
    $g.FillPath($cBg, $cPath)
    $cBorder = New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(50, 71, 85, 105), 1)
    $g.DrawPath($cBorder, $cPath)
    $cBg.Dispose()
    $cBorder.Dispose()
    $cPath.Dispose()
    
    # Accent indicator bar on left of card
    $barBrush = New-Object System.Drawing.SolidBrush($f.Color)
    $barRect = New-Object System.Drawing.Rectangle($contentX + 12, $cy + 15, 4, 30)
    $g.FillRectangle($barBrush, $barRect)
    
    # Stat text
    $g.DrawString($f.Stat, $statFont, $barBrush, $contentX + 26, $cy + 16)
    $barBrush.Dispose()
    
    # Measure stat to place label
    $sSize = $g.MeasureString($f.Stat, $statFont)
    $lBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(255, 226, 232, 240))
    $g.DrawString($f.Label, $labelFont, $lBrush, $contentX + 26 + [int]$sSize.Width + 12, $cy + 20)
    $lBrush.Dispose()
}

$statFont.Dispose()
$labelFont.Dispose()

# Save PNG
$bmp.Save((Resolve-Path (Join-Path $PSScriptRoot "..\play_store_assets\feature_graphic_1024x500.png")).Path, [System.Drawing.Imaging.ImageFormat]::Png)

# Save high-quality JPG
$jpgEncoder = [System.Drawing.Imaging.ImageCodecInfo]::GetImageEncoders() | Where-Object { $_.FormatDescription -eq "JPEG" }
$encoderParams = New-Object System.Drawing.Imaging.EncoderParameters(1)
$encoderParams.Param[0] = New-Object System.Drawing.Imaging.EncoderParameter([System.Drawing.Imaging.Encoder]::Quality, [long]95)
$bmp.Save((Resolve-Path (Join-Path $PSScriptRoot "..\play_store_assets\feature_graphic_1024x500.jpg")).Path, $jpgEncoder, $encoderParams)

$g.Dispose()
$bmp.Dispose()

Write-Host "Feature Graphic generated successfully at 1024x500 (PNG & JPG) with exact Candidate 3 App Icon!"

