# SilentGPT

This tool monitors the clipboard for new copy events, sends the content to the ChatGPT API, and replaces the clipboard content with the response.

## Features

- No API key required
- Its running in the background so no one can actually see that you are using SilentGPT
- Copy specific commands to your clipboard for running actions (read below)
- This tool can remember the previous conversation like in the normal ChatGPT interface
- This tool can play a sound (windows sound) for notifying you as soon as the answer is in your clipboard

## Commands

If you want to execute one of the following actions you just have to copy the command into your clipboard
- Close SilentGPT
```
SILENTGPT_CLOSE
```
- Toggle notifications (disabled by default)
```
SILENTGPT_NOTIFY
```
- Toggle remembering conversations (disabled by default)
```
SILENTGPT_REMEMBER_CONVERSATION
```

## Installation

1. **Requirements:**
    - Java Development Kit (JDK) 11 or higher

2. **Download:**
    - Download the latest release from the [Releases page](https://github.com/SocketC0nnection/SilentGPT/releases).

## Usage

1. **Start:**
    - Run the JAR file via command-line or just double click it:

      ```sh
      java -jar SilentGPT.jar
      ```

2. **Monitor Clipboard:**
    - Copy text to the clipboard. The tool will automatically send the text to the ChatGPT API and replace the clipboard content with the response.

## Contributions
Contributions are welcome! If you find a bug or have a feature request, please open an issue or submit a pull request.

## License
This project is licensed under the MIT License. See the LICENSE file for details.

## Acknowledgements
- Gson for JSON processing
- [aiforcause](https://github.com/brahmai-research/aiforcause) for accessing ChatGPT API