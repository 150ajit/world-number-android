Add-Type -AssemblyName System.Drawing
$fonts = (New-Object System.Drawing.Text.InstalledFontCollection).Families | Select-Object -ExpandProperty Name
@("Segoe UI", "Segoe UI Semibold", "Segoe UI Bold", "Montserrat", "Roboto", "Arial", "Inter", "Trebuchet MS", "Bahnschrift") | ForEach-Object {
    $found = $fonts -contains $_
    Write-Host "$_ : $found"
}

