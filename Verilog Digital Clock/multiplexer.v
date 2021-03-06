/* Objective: To display the alarm time and to sound an alarm
 * 1. Output "display_time" will represent the value of "alarm_time" when 
 *     "show_a" is 1 and "current_time" when "show_a" is 0
 * 2. To represent one digit of the alarm clock use four bit data bus
 * 3. Use wire and 4-bit vector to represent data
 * 4. Use rather logical expression or simple if else statement
 * 5. To sound an alarm when both the "current_time" is same as "alarm_time"
 * 6. Use a register for a variable that is used within procedure
 */
module mltiplexer(display_time, sound_alarm, alarm_time, current_time, show_alarm);
output [15:0] display_time;
output sound_alarm;
input [15:0] alarm_time, current_time; 
input show_alarm;
reg sound_alarm;

assign display_time = (show_alarm) ? alarm_time : current_time;

always@(current_time or alarm_time)
begin
	if(current_time == alarm_time)
		sound_alarm = 1'b1;
	else
		sound_alarm = 1'b0; 
end
endmodule
