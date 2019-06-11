/* Objective: this will generate one_second and one_minute timing pulses for counting Guidelines:
 * 1.	Assume 256 cycles/sec as board clock
 * 2.	Use the appropriate width for the counter
 * 3.	Make sure the reset is asynchronous
 * 4.	Use procedure blocks to infer sequential logic and continuous assignments to infer combinational logic
 */
module generator(one_sec,one_min);
output one_sec, one_min;
reg [7:0] count;
reg [5:0] seconds;
reg one_min, one_sec;

initial
	count = 0;

always begin
	one_sec = 0;
	count = count + 1;
	if(count == 256) begin
		one_sec = 1;
		seconds = seconds + 1;
		count = 0;
	end
end

always@(seconds) begin
	if (seconds == 59) begin
		one_min = 1;
		seconds = 0;
	end 
	else
		one_min = 0;
end
endmodule
