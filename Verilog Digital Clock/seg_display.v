/* Objective: To display the clock values/digits
 * 1.	Use case statement to to assign seven segment display values to output.
 */
module seg_display(display, display_time);
output [7:0] display;
input [3:0] display_time;
reg [7:0] display;
parameter zero_seg = 7'b1111110,
	one_seg = 7'b0110000,
	two_seg = 7'b1101101,
	three_seg = 7'b1111001,
	four_seg = 7'b0110011,
	five_seg = 7'b1001111,
	six_seg = 7'b1011111,
	seven_seg = 7'b1110000,
	eight_seg = 7'b1111111,
	nine_seg = 7'b1111011;

always@(display_time)
begin
	case(display_time)
		4'b0000:  display = zero_seg;
		4'b0001:  display = one_seg;
		4'b0010:  display = two_seg;
		4'b0011:  display = three_seg;
		4'b0100:  display = four_seg;
		4'b0101:  display = five_seg;
		4'b0110:  display = six_seg;
		4'b0111:  display = seven_seg;
		4'b1000:  display = eight_seg;
		4'b1001:  display = nine_seg;
	endcase
end
endmodule
