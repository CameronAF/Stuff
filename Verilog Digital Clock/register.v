/* Objective: Register which will store the alarm time and defining the 
 *   registered logic which will retain value or load new value
 * If load_new_alarm is ture then register stores the value of the new_alarm_time, 
 *   else it retains the present value. Use the asynchronous for checking the value of reset
 */
module alarm_register(alarm_time, new_alarm_time, load_new_alarm, reset);
output [15:0] alarm_time;
input [15:0] new_alarm_time;
input load_new_alarm, reset;
reg [15:0] alarm_time;

always@(posedge load_new_alarm or posedge reset)
begin
	if (reset == 1'b1)
		alarm_time = 0;
	else
		alarm_time = new_alarm_time;
end
endmodule
	