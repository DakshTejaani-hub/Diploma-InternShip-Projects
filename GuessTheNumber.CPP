#include <stdio.h>
#include <conio.h>
#include <graphics.h>
#include <stdlib.h>
#include <time.h>
#include <dos.h>
#include <string.h>

// Game Constants
#define MAX_ATTEMPTS 8
#define MIN_NUMBER 1
#define MAX_NUMBER 100

// Graphics Display Class
class Display {
public:
    void initializeGraphics() {
        int gdriver = DETECT, gmode;
        initgraph(&gdriver, &gmode, "c:\\turboc3\\bgi");
        
        if (graphresult() != grOk) {
            printf("Graphics error! Check BGI files in c:\\turboc3\\bgi");
            getch();
            exit(1);
        }
        setbkcolor(BLACK);
        cleardevice();
    }
    
    void drawTitle() {
        setcolor(YELLOW);
        settextstyle(DEFAULT_FONT, HORIZ_DIR, 2);
        outtextxy(200, 50, "GUESS THE NUMBER");
        
        setcolor(WHITE);
        settextstyle(DEFAULT_FONT, HORIZ_DIR, 1);
        outtextxy(220, 80, "Ultimate Guessing Game");
        
        // Decorative border
        setcolor(CYAN);
        rectangle(50, 30, 590, 450);
    }
    
    void drawGamePanel(int attempts, int minRange, int maxRange) {
        char temp[50];
        
        cleardevice();
        drawTitle();
        
        // Game panel
        setcolor(GREEN);
        rectangle(80, 120, 560, 400);
        
        setcolor(WHITE);
        outtextxy(100, 140, "GAME STATUS");
        
        sprintf(temp, "Attempts Used: %d / %d", attempts, MAX_ATTEMPTS);
        outtextxy(100, 170, temp);
        
        sprintf(temp, "Current Range: %d - %d", minRange, maxRange);
        outtextxy(100, 200, temp);
        
        setcolor(YELLOW);
        outtextxy(100, 240, "Enter your guess (1-100):");
        
        // Input box
        setcolor(WHITE);
        rectangle(100, 260, 300, 300);
        
        setcolor(LIGHTGRAY);
        outtextxy(100, 320, "Press ENTER to guess");
        outtextxy(100, 340, "Press 'Q' to quit");
    }
    
    void displayGuess(int guess) {
        char guessStr[10];
        sprintf(guessStr, "%d", guess);
        
        // Clear input box
        setfillstyle(SOLID_FILL, BLACK);
        bar(101, 261, 299, 299);
        
        setcolor(YELLOW);
        outtextxy(110, 275, guessStr);
    }
    
    void showHint(char* message, int colorType) {
        // Clear hint area
        setfillstyle(SOLID_FILL, BLACK);
        bar(320, 260, 550, 300);
        
        // Set color: 1=Green(correct), 2=Red(wrong), 3=Blue(info)
        if (colorType == 1) setcolor(GREEN);
        else if (colorType == 2) setcolor(RED);
        else setcolor(BLUE);
        
        outtextxy(330, 275, message);
    }
    
    void drawProgressBar(int attempts) {
        int x = 100, y = 360, width = 300, height = 15;
        int progress = (attempts * width) / MAX_ATTEMPTS;
        
        // Progress bar outline
        setcolor(WHITE);
        rectangle(x, y, x + width, y + height);
        
        // Progress fill
        if (attempts < MAX_ATTEMPTS / 2) setcolor(GREEN);
        else if (attempts < 3 * MAX_ATTEMPTS / 4) setcolor(YELLOW);
        else setcolor(RED);
        
        setfillstyle(SOLID_FILL, getcolor());
        bar(x + 1, y + 1, x + progress, y + height - 1);
        
        setcolor(WHITE);
        outtextxy(x + width + 10, y + 3, "Progress");
    }
    
    void showWinScreen(int attempts) {
        char msg[50];
        cleardevice();
        
        setcolor(YELLOW);
        settextstyle(DEFAULT_FONT, HORIZ_DIR, 3);
	outtextxy(150, 150, "CONGRATULATIONS!");
        
        setcolor(GREEN);
        settextstyle(DEFAULT_FONT, HORIZ_DIR, 2);
        outtextxy(250, 200, "YOU WON!");
        
        settextstyle(DEFAULT_FONT, HORIZ_DIR, 1);
        sprintf(msg, "You guessed it in %d attempts!", attempts);
        outtextxy(200, 250, msg);
        
        setcolor(WHITE);
        outtextxy(200, 300, "Press 'P' to play again");
        outtextxy(200, 320, "Press 'Q' to quit");
        
        // Draw celebration border
	setcolor(YELLOW);
	for (int i = 0; i < 5; i++)
	{
	    rectangle(100 - i*10, 100 - i*10, 540 + i*10, 400 + i*10);
	    delay(200);
	}
    }

    void showLoseScreen(int secretNumber) {
	char msg[50];
	cleardevice();

	setcolor(RED);
	settextstyle(DEFAULT_FONT, HORIZ_DIR, 3);
	outtextxy(220, 150, "GAME OVER!");

	settextstyle(DEFAULT_FONT, HORIZ_DIR, 1);
	sprintf(msg, "The number was: %d", secretNumber);
	setcolor(YELLOW);
	outtextxy(250, 200, msg);

	setcolor(WHITE);
	outtextxy(200, 250, "Better luck next time!");
	outtextxy(200, 300, "Press 'P' to play again");
	outtextxy(200, 320, "Press 'Q' to quit");
    }
};

// Number Generator Class
class NumberGenerator {
private:
    int secretNumber;
    int minRange;
    int maxRange;

public:
    NumberGenerator() {
	minRange = MIN_NUMBER;
	maxRange = MAX_NUMBER;
	generateNewNumber();
    }

    void generateNewNumber() {
	srand(time(NULL) + rand());
	secretNumber = (rand() % (maxRange - minRange + 1)) + minRange;
    }

    int getSecretNumber() {
	return secretNumber;
    }

    int getMinRange() {
	return minRange;
    }

    int getMaxRange() {
	return maxRange;
    }

    void updateRange(int guess) {
	if (guess < secretNumber && guess >= minRange) {
	    minRange = guess + 1;
	}
	else if (guess > secretNumber && guess <= maxRange) {
	    maxRange = guess - 1;
	}
    }

    void resetRange() {
	minRange = MIN_NUMBER;
	maxRange = MAX_NUMBER;
    }
};

// Player Class
class Player {
private:
    int attempts;
    int currentGuess;
    int bestScore;

public:
    Player() {
	attempts = 0;
	currentGuess = 0;
	bestScore = MAX_ATTEMPTS + 1;
    }

    void resetAttempts() {
	attempts = 0;
	currentGuess = 0;
    }

    void incrementAttempts() {
	attempts++;
    }

    int getAttempts() {
	return attempts;
    }

    void setGuess(int guess) {
	currentGuess = guess;
    }

    int getGuess() {
	return currentGuess;
    }

    void updateBestScore() {
	if (attempts < bestScore) {
	    bestScore = attempts;
	}
    }

    int getBestScore() {
	return (bestScore > MAX_ATTEMPTS) ? 0 : bestScore;
    }

    int isValidGuess(int guess) {
	return (guess >= MIN_NUMBER && guess <= MAX_NUMBER);
    }
};

// Main Game Engine Class
class GameEngine {
private:
    Display display;
    NumberGenerator numGen;
    Player player;
    int gameState; // 0=playing, 1=won, 2=lost, 3=quit

public:
    GameEngine() {
	gameState = 0;
    }

    void initializeGame() {
	display.initializeGraphics();
	// Don't call srand here since it's handled in NumberGenerator
	numGen.generateNewNumber();
	player.resetAttempts();
	numGen.resetRange();
	gameState = 0;
    }

    int getInput() {
	char inputStr[10];
	char ch;
	int index = 0;
	int guess = 0;

	// Clear input string
	for (int i = 0; i < 10; i++) {
	    inputStr[i] = '\0';
	}

	while (1) {
	    ch = getch();

	    if (ch == 'q' || ch == 'Q') {
		gameState = 3;
		return -1;
	    }

	    if (ch == 13) { // Enter key
		if (index > 0) {
		    guess = atoi(inputStr);
		    return guess;
		}
	    }

	    if (ch == 8) { // Backspace
		if (index > 0) {
		    index--;
		    inputStr[index] = '\0';
		    display.displayGuess(atoi(inputStr));
		}
	    }

	    if (ch >= '0' && ch <= '9' && index < 3) {
		inputStr[index] = ch;
		index++;
		inputStr[index] = '\0';
		display.displayGuess(atoi(inputStr));
	    }
	}
    }

    void processGuess(int guess) {
	char hint[30];
	int secret = numGen.getSecretNumber();

	player.setGuess(guess);
	player.incrementAttempts();

	if (guess == secret) {
	    strcpy(hint, "CORRECT! You Win!");
	    display.showHint(hint, 1);
	    delay(2000);
	    gameState = 1;
	    player.updateBestScore();
	}
	else if (guess < secret) {
	    strcpy(hint, "Too LOW! Try Higher");
	    display.showHint(hint, 2);
	    numGen.updateRange(guess);
	}
	else {
	    strcpy(hint, "Too HIGH! Try Lower");
	    display.showHint(hint, 2);
	    numGen.updateRange(guess);
	}

	if (player.getAttempts() >= MAX_ATTEMPTS && gameState == 0) {
	    delay(1500);
	    gameState = 2;
	}

	delay(1000);
    }

    void runGame() {
	int guess;

	while (gameState == 0) {
	    display.drawGamePanel(player.getAttempts(),
				numGen.getMinRange(),
				numGen.getMaxRange());
	    display.drawProgressBar(player.getAttempts());

	    guess = getInput();

	    if (gameState == 3) break; // Quit

	    if (player.isValidGuess(guess)) {
		processGuess(guess);
	    } else {
		display.showHint("Invalid! (1-100)", 3);
		delay(1000);
	    }
	}

	if (gameState == 1) {
	    display.showWinScreen(player.getAttempts());
	}
	else if (gameState == 2) {
	    display.showLoseScreen(numGen.getSecretNumber());
	}
    }

    int handleGameEnd() {
	char ch;

	if (gameState == 3) return 0; // Quit

	while (1) {
	    ch = getch();
	    if (ch == 'p' || ch == 'P') {
		return 1; // Play again
	    }
	    if (ch == 'q' || ch == 'Q') {
		return 0; // Quit
	    }
	}
    }

    void cleanup() {
	closegraph();
    }
};

// Main Function
int main() {
    GameEngine game;
    int playAgain = 1;

    while (playAgain) {
	game.initializeGame();
	game.runGame();
	playAgain = game.handleGameEnd();
    }

    game.cleanup();
    return 0;
}