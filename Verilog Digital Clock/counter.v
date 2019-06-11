/* Objective: Complete counting mechanism in the alarm clock design that counts minutes and hours
 * 1.	Signals current_time and new_current_time each consists of four bit vectors
 * 2.	The incrementor operates on all four digits of alarm clock similar to normal 24-hour clock
 * 3.	If load_new_c is true, then the register stores the new time, 
 *      otherwise if one_minute is true it stores its present value incremented by one
 * 4.	If load_new_c and one_minute are false then the value of the counter will not change
 * 5.	Use appropriate coding style
 */
module counter(current_time, new_current_time, load_new_c, one_minute);
output [15:0] current_time;
input [15:0] new_current_time;
input load_new_c, one_minute;
reg [3:0] ms_hr, ls_hr, ms_min, ls_min; 
reg [15:0] current_time;
reg carry;

initial begin
    carry = 0;
    current_time = 0;
end

always @(ms_hr or ls_hr or ms_min or ls_min)
  current_time = {ms_hr, ls_hr, ms_min, ls_min};

always @(current_time)
  {ms_hr, ls_hr, ms_min, ls_min} = new_current_time;

always@(posedge load_new_c or posedge one_minute) begin
  if (load_new_c == 1) begin
    current_time = new_current_time;
  end
  else if (one_minute == 1) begin
    ls_min = ls_min + 1;
    if (ls_min == 10) begin
      ms_min = ms_min + 1;
      ls_min = 0;
      carry = 1;
    end
    else
      carry = 0;
  end
end

always@(ms_min) begin
  if (carry == 1) begin
    if (ms_min == 6) begin
      ls_hr = ls_hr + 1;
      ms_min = 0;
      carry = 1;
    end
  end
end

always@(ls_hr or ms_hr) begin
  if (carry == 1) begin
    if (ls_hr == 6) begin
      ms_hr = ms_hr + 1;
      ls_hr = 0;
      carry = 1;
    end
  end
end
endmodule