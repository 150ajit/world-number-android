const fs = require('fs');
const path = require('path');

// 1. Fix SettingsScreen.kt
const settingsFile = path.resolve('app/src/main/java/com/example/worldpopulation/presentation/settings/SettingsScreen.kt');
let settingsContent = fs.readFileSync(settingsFile, 'utf8');

if (!settingsContent.includes('import androidx.compose.ui.graphics.Color')) {
    settingsContent = settingsContent.replace(
        'import androidx.compose.ui.draw.clip',
        'import androidx.compose.ui.draw.clip\nimport androidx.compose.ui.graphics.Color'
    );
    fs.writeFileSync(settingsFile, settingsContent, 'utf8');
    console.log('Added Color import to SettingsScreen.kt');
} else {
    console.log('SettingsScreen already has Color import');
}

// 2. Fix CountryDetailsScreen.kt
const countryFile = path.resolve('app/src/main/java/com/example/worldpopulation/presentation/countrydetails/CountryDetailsScreen.kt');
let countryContent = fs.readFileSync(countryFile, 'utf8');

// Add Color import
if (!countryContent.includes('import androidx.compose.ui.graphics.Color')) {
    countryContent = countryContent.replace(
        'import androidx.compose.ui.draw.clip',
        'import androidx.compose.ui.draw.clip\nimport androidx.compose.ui.graphics.Color'
    );
    console.log('Added Color import to CountryDetailsScreen.kt');
} else {
    console.log('CountryDetailsScreen already has Color import');
}

// Fix item { nesting
// In CountryDetailsScreen, the OVERVIEW tab starts:
//   when (state.selectedTab) {
//       CountryDetailTab.OVERVIEW -> {
//           item {
//               if (country != null) {
//                   Card(...) { ... }
//               }
//           <-- We need to close item { here!
//           // Global Category Indicators Section
//           if (state.categoryValues.isNotEmpty()) {
//               item { ... }
//               groupedByCategory.forEach { item { ... } }
//           }
//       } <-- OVERVIEW ends here

const target1 = `                                    Column(horizontalAlignment = Alignment.End) {
                                        Text("Data Classification", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                        Text(country.dataType.name, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.primary)
                                    }
                                }
                            }
                        }
                    }

                    // Global Category Indicators Section`;

const replacement1 = `                                    Column(horizontalAlignment = Alignment.End) {
                                        Text("Data Classification", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                        Text(country.dataType.name, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.primary)
                                    }
                                }
                            }
                        }
                    }
                }

                // Global Category Indicators Section`;

// And at the end of OVERVIEW, remove the extra closing brace:
const target2 = `                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            CountryDetailTab.DEMOGRAPHICS -> {`;

const replacement2 = `                                        }
                                    }
                                }
                            }
                        }
                    }
            }

            CountryDetailTab.DEMOGRAPHICS -> {`;

// Normalize \r\n to \n for replacement
const normalized = countryContent.replace(/\r\n/g, '\n');
if (normalized.includes(target1)) {
    const updated = normalized.replace(target1, replacement1).replace(target2, replacement2);
    // Keep LF line endings
    fs.writeFileSync(countryFile, updated, 'utf8');
    console.log('Successfully applied item-scoping fix to CountryDetailsScreen.kt');
} else {
    console.error('ERROR: target1 not found in CountryDetailsScreen.kt!');
}
