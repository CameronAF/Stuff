/* Objective: design state machine that controls alarm clock and create a sophisticated testbench to verify its correctness
 * 1.	Pressing 0-9 keys: when one of the keys is pressed, the display changes to show the key that is pressed in the rightmost position. As other keys are pressed, the digits move along the left. If no key pressed for 10 seconds then the display returns to showing the current time
 * 2.	Load new alarm: the user enters the new time, and presses the alarm key. The display will show the current time once the alarm key has been pressed.
 * 3.	Loading the new current time: user enters new time, and presses the time key. Display will show new current time.
 * 4.	To show the time alarm is set for: user presses the alarm key without previously entering any of the numeric keys. The display will show the alarm time for as long as alarm key is held.
 */
