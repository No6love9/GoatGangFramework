# GoatGang Framework - OSRS DreamBot 4 Client Bot

The GoatGang Framework is a robust, Java-based OSRS bot designed for the DreamBot 4 API. It seamlessly integrates into the DreamBot client and provides automated services and interactive games.

## Features

- **Standalone JAR**: Fully packaged and compatible with the latest DreamBot 4 API.
- **Integrated Games**:
    - **Flower Poker**: Real-time flower poker logic with hand evaluation.
    - **Dice Game**: Automated dice rolling with configurable win chances.
- **Automated Services**:
    - **AutoChatter**: Customizable automated messaging service.
    - **Economy System**: Persistent balance management for players.
- **Real-time GUI**: A dedicated control panel to manage the bot's state and view statistics.
- **Rich Paint UI**: On-screen display for runtime, status, and economy tracking.

## Setup Instructions

1.  **Download the JAR**: Use the provided `goatgang-bot-1.0.jar`.
2.  **Place in Scripts Folder**: Move the JAR to your DreamBot scripts directory (usually `~/DreamBot/Scripts/`).
3.  **Launch DreamBot**: Open the DreamBot client and log in.
4.  **Start the Script**: Find "GoatGang Framework" in your script list and click "Start".

## Commands & Logic

- The bot automatically tracks player balances and game statistics.
- Use the GUI to configure automated services like the AutoChatter.
- The Flower Poker logic includes full hand ranking from Pair to Rainbow Hand.

## Technical Details

- **Language**: Java
- **API**: DreamBot 4
- **Build System**: Maven
- **Compatibility**: OSRS Latest
