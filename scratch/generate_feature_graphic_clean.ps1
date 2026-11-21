Add-Type -AssemblyName System.Drawing

[int]$width = 1024
[int]$height = 500

$srcIconPath = (Resolve-Path (Join-Path $PSScriptRoot "..\play_store_assets\logo_candidates\candidate3_cyber_mesh.jpg")).Path
$destPng = (Join-Path $PSScriptRoot "..\play_store_assets\feature_graphic_1024x500.png")
$destJpg = (Join-Path $PSScriptRoot "..\play_store_assets\feature_graphic_1024x500.jpg")

$bmp = New-Object System.Drawing.Bitmap($width, $height, [System.Drawing.Imaging.PixelFormat]::Format32bppArgb)
$g = [System.Drawing.Graphics]::FromImage($bmp)
$g.SmoothingMode = [System.Drawing.Drawing2D.SmoothingMode]::HighQuality
$g.InterpolationMode = [System.Drawing.Drawing2D.InterpolationMode]::HighQualityBicubic
$g.PixelOffsetMode = [System.Drawing.Drawing2D.PixelOffsetMode]::HighQuality
$g.TextRenderingHint = [System.Drawing.Text.TextRenderingHint]::ClearTypeGridFit

# Helper for rounded rectangles
function New-RoundRectPath([int]$x, [int]$y, [int]$w, [int]$h, [int]$radius) {
    $path = New-Object System.Drawing.Drawing2D.GraphicsPath
    [int]$d = $radius * 2
    $path.AddArc($x, $y, $d, $d, 180, 90)
    $path.AddArc(($x + $w - $d), $y, $d, $d, 270, 90)
    $path.AddArc(($x + $w - $d), ($y + $h - $d), $d, $d, 0, 90)
    $path.AddArc($x, ($y + $h - $d), $d, $d, 90, 90)
    $path.CloseFigure()
    return $path
}

# 1. Background
$bgRect = New-Object System.Drawing.Rectangle(0, 0, $width, $height)
$bgBrush = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
    (New-Object System.Drawing.Point(0, 0)),
    (New-Object System.Drawing.Point($width, $height)),
    [System.Drawing.Color]::FromArgb(255, 11, 17, 28),
    [System.Drawing.Color]::FromArgb(255, 15, 23, 42)
)
$g.FillRectangle($bgBrush, $bgRect)
$bgBrush.Dispose()

# Ambient radial glow behind icon
for ([int]$r = 260; $r -ge 60; $r -= 20) {
    [int]$alpha = [int](22 * (1.0 - ($r / 260.0)))
    $glowBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb($alpha, 6, 182, 212))
    $g.FillEllipse($glowBrush, [int](235 - $r), [int](250 - $r), [int]($r * 2), [int]($r * 2))
    $glowBrush.Dispose()
}

# Ambient secondary emerald glow
for ([int]$r = 180; $r -ge 50; $r -= 25) {
    [int]$alpha = [int](16 * (1.0 - ($r / 180.0)))
    $glowBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb($alpha, 16, 185, 129))
    $g.FillEllipse($glowBrush, [int](310 - $r), [int](330 - $r), [int]($r * 2), [int]($r * 2))
    $glowBrush.Dispose()
}

# Subtle Tech Grid Pattern
$gridPen = New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(12, 148, 163, 184), 1)
for ([int]$gx = 0; $gx -lt $width; $gx += 48) {
    $g.DrawLine($gridPen, $gx, 0, $gx, $height)
}
for ([int]$gy = 0; $gy -lt $height; $gy += 48) {
    $g.DrawLine($gridPen, 0, $gy, $width, $gy)
}
$gridPen.Dispose()

# Tech brackets / corner accents
$accentPen = New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(60, 6, 182, 212), 1)
$g.DrawLine($accentPen, 32, 32, 56, 32)
$g.DrawLine($accentPen, 32, 32, 32, 56)
$g.DrawLine($accentPen, 992, 32, 968, 32)
$g.DrawLine($accentPen, 992, 32, 992, 56)
$g.DrawLine($accentPen, 32, 468, 56, 468)
$g.DrawLine($accentPen, 32, 468, 32, 444)
$g.DrawLine($accentPen, 992, 468, 968, 468)
$g.DrawLine($accentPen, 992, 468, 992, 444)
$accentPen.Dispose()

# 2. Draw Exact App Icon (Candidate 3)
[int]$iconSize = 340
[int]$iconX = 70
[int]$iconY = 80
[int]$iconRadius = 64

# Shadow passes
for ([int]$s = 14; $s -ge 2; $s -= 2) {
    [int]$sAlpha = [int](10 * (1.0 - ($s / 14.0)))
    [int]$sx = $iconX - $s
    [int]$sy = $iconY - $s + 4
    [int]$sw = $iconSize + ($s * 2)
    [int]$sh = $iconSize + ($s * 2)
    $sPath = New-RoundRectPath $sx $sy $sw $sh ($iconRadius + $s)
    $sBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb($sAlpha, 0, 0, 0))
    $g.FillPath($sBrush, $sPath)
    $sBrush.Dispose()
    $sPath.Dispose()
}

# Icon draw with clipping
$srcIcon = [System.Drawing.Image]::FromFile($srcIconPath)
$iconPath = New-RoundRectPath $iconX $iconY $iconSize $iconSize $iconRadius
$state = $g.Save()
$g.SetClip($iconPath)
$iconRect = New-Object System.Drawing.Rectangle($iconX, $iconY, $iconSize, $iconSize)
$g.DrawImage($srcIcon, $iconRect)
$g.Restore($state)

# Glowing outline border on icon card
$pt1 = New-Object System.Drawing.Point($iconX, $iconY)
$pt2 = New-Object System.Drawing.Point(($iconX + $iconSize), ($iconY + $iconSize))
$borderBrush = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
    $pt1,
    $pt2,
    [System.Drawing.Color]::FromArgb(200, 56, 189, 248),
    [System.Drawing.Color]::FromArgb(140, 16, 185, 129)
)
$borderPen = New-Object System.Drawing.Pen($borderBrush, [float]2.5)
$g.DrawPath($borderPen, $iconPath)
$borderPen.Dispose()
$borderBrush.Dispose()
$iconPath.Dispose()
$srcIcon.Dispose()

# 3. Typography & Right-Side Content
[int]$contentX = 455

# Live Demographics Pill
[int]$pillX = $contentX
[int]$pillY = 72
[int]$pillW = 195
[int]$pillH = 30
$pillPath = New-RoundRectPath $pillX $pillY $pillW $pillH 15
$pillBg = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(200, 15, 30, 52))
$g.FillPath($pillBg, $pillPath)
$pillBorder = New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(120, 6, 182, 212), [float]1.2)
$g.DrawPath($pillBorder, $pillPath)
$pillBg.Dispose()
$pillBorder.Dispose()
$pillPath.Dispose()

# Green dot in pill
$dotBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(255, 16, 185, 129))
$g.FillEllipse($dotBrush, ($pillX + 12), ($pillY + 10), 10, 10)
$dotBrush.Dispose()

# Pill Text
$pillFont = New-Object System.Drawing.Font("Segoe UI", [float]9.0, [System.Drawing.FontStyle]::Bold)
$pillTextBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(255, 56, 189, 248))
$g.DrawString("LIVE DEMOGRAPHICS", $pillFont, $pillTextBrush, [float]($pillX + 28), [float]($pillY + 6))
$pillFont.Dispose()
$pillTextBrush.Dispose()

# Main Title: "WorldNumber"
$titleFont = New-Object System.Drawing.Font("Segoe UI", [float]44.0, [System.Drawing.FontStyle]::Bold)
[int]$titleY = 114

$worldSize = $g.MeasureString("World", $titleFont)
[int]$worldW = [int]$worldSize.Width

$whiteBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(255, 255, 255, 255))
$g.DrawString("World", $titleFont, $whiteBrush, [float]$contentX, [float]$titleY)
$whiteBrush.Dispose()

$ptTitle1 = New-Object System.Drawing.Point(($contentX + $worldW - 14), $titleY)
$ptTitle2 = New-Object System.Drawing.Point(($contentX + $worldW + 240), ($titleY + 60))
$cyanBrush = New-Object System.Drawing.Drawing2D.LinearGradientBrush(
    $ptTitle1,
    $ptTitle2,
    [System.Drawing.Color]::FromArgb(255, 34, 211, 238),
    [System.Drawing.Color]::FromArgb(255, 52, 211, 153)
)
$g.DrawString("Number", $titleFont, $cyanBrush, [float]($contentX + $worldW - 14), [float]$titleY)
$cyanBrush.Dispose()
$titleFont.Dispose()

# Subtitle
$tagFont = New-Object System.Drawing.Font("Segoe UI", [float]14.5, [System.Drawing.FontStyle]::Regular)
$tagBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(255, 148, 163, 184))
$g.DrawString("Real-Time Global Population & Demographic Engine", $tagFont, $tagBrush, [float]$contentX, [float]196)
$tagFont.Dispose()
$tagBrush.Dispose()

# Divider line
$divPen = New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(60, 51, 65, 85), [float]1.0)
$g.DrawLine($divPen, $contentX, 236, 960, 236)
$divPen.Dispose()

# Feature Badges
$features = @(
    @{ Stat = "8.14B+"; Label = "Real-Time Population Counter"; Color = [System.Drawing.Color]::FromArgb(255, 6, 182, 212) },
    @{ Stat = "195+";   Label = "Countries & Global Rankings";   Color = [System.Drawing.Color]::FromArgb(255, 16, 185, 129) },
    @{ Stat = "ms Sync"; Label = "Dynamic Timezone Calibration"; Color = [System.Drawing.Color]::FromArgb(255, 168, 85, 247) }
)

[int]$cardY = 256
[int]$cardW = 505
[int]$cardH = 58
$statFont = New-Object System.Drawing.Font("Segoe UI", [float]15.0, [System.Drawing.FontStyle]::Bold)
$labelFont = New-Object System.Drawing.Font("Segoe UI", [float]11.0, [System.Drawing.FontStyle]::Regular)

for ([int]$i = 0; $i -lt $features.Count; $i++) {
    $f = $features[$i]
    [int]$cy = $cardY + ($i * 68)
    
    # Card Background
    $cPath = New-RoundRectPath $contentX $cy $cardW $cardH 12
    $cBg = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(140, 20, 30, 48))
    $g.FillPath($cBg, $cPath)
    $cBorder = New-Object System.Drawing.Pen([System.Drawing.Color]::FromArgb(60, 71, 85, 105), [float]1.0)
    $g.DrawPath($cBorder, $cPath)
    $cBg.Dispose()
    $cBorder.Dispose()
    $cPath.Dispose()
    
    # Accent indicator bar on left
    $barBrush = New-Object System.Drawing.SolidBrush($f.Color)
    $g.FillRectangle($barBrush, ($contentX + 12), ($cy + 14), 4, 30)
    
    # Stat text
    $g.DrawString($f.Stat, $statFont, $barBrush, [float]($contentX + 26), [float]($cy + 16))
    $barBrush.Dispose()
    
    # Measure stat to place label
    $sSize = $g.MeasureString($f.Stat, $statFont)
    [int]$sw = [int]$sSize.Width
    $lBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(255, 226, 232, 240))
    $g.DrawString($f.Label, $labelFont, $lBrush, [float]($contentX + 26 + $sw + 12), [float]($cy + 20))
    $lBrush.Dispose()
}

$statFont.Dispose()
$labelFont.Dispose()

# Save PNG
$bmp.Save($destPng, [System.Drawing.Imaging.ImageFormat]::Png)

# Save high-quality JPG
$jpgEncoder = [System.Drawing.Imaging.ImageCodecInfo]::GetImageEncoders() | Where-Object { $_.FormatDescription -eq "JPEG" }
$encoderParams = New-Object System.Drawing.Imaging.EncoderParameters(1)
$encoderParams.Param[0] = New-Object System.Drawing.Imaging.EncoderParameter([System.Drawing.Imaging.Encoder]::Quality, [long]95)
$bmp.Save($destJpg, $jpgEncoder, $encoderParams)

$g.Dispose()
$bmp.Dispose()

Write-Host "SUCCESS: Generated feature_graphic_1024x500.png and .jpg with exact Candidate 3 App Icon!"

