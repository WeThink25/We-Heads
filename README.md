# WeHead Plugin

A Minecraft plugin for **Spigot/Paper/Folia (1.20+)** that allows players to get custom heads using Base64 textures.

## Features

- **Simple Base64 Support**: Direct Base64 texture injection into SkullMeta
- **Easy to Use**: Single command with Base64 texture input
- **Inventory Management**: Automatic overflow protection
- **Permission System**: Built-in permission controls

## Commands

### `/wehead give <base64_texture>`

Give yourself a custom head using a Base64 texture string from minecraft-heads.com.

**Example:**
```
/wehead give eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv...
```

## Permissions

| Permission | Description | Default |
|------------|-------------|---------|
| `wehead.give` | Allows using `/wehead give` command | `op` |

## Installation

1. Download the plugin JAR file
2. Place it in your server's `plugins/` folder
3. Restart your server
4. Plugin is ready to use!

## Requirements

- **Minecraft Version**: 1.20+
- **Server Software**: Spigot, Paper, or Folia
- **Java Version**: 21+

## Building from Source

```bash
git clone https://github.com/wethink/we-heads.git
cd we-heads
mvn clean package
```

The compiled JAR will be in the `target/` directory.

## Getting Base64 Textures

1. Visit [minecraft-heads.com](https://minecraft-heads.com)
2. Find the head you want
3. Copy the Base64 texture value
4. Use it with `/wehead give <base64_texture>`

## Error Handling

- **Invalid Command**: Shows usage message
- **No Permission**: Permission denied message
- **Invalid Texture**: Error message with texture validation
- **Full Inventory**: Drops head on ground if inventory is full

## Support

For issues, feature requests, or contributions, please visit our GitHub repository.

## License

This project is licensed under the MIT License.
