/*
 * this is the matrix keypad model used in the alarm clock design 
 */

module keypad (key, columns, rows);

input [3:0] key;
input [2:0] columns;

output [3:0] rows;
reg [3:0] rows;

always @ (key or columns)
begin
	rows < = 4'b1111;
	case (key)
		0	: rows[0] <= column[1];
		1	: rows[3] <= column[2];
		2	: rows[3] <= column[1];
		3	: rows[3] <= column[0];
		4	: rows[2] <= column[2];
		5	: rows[2] <= column[1];
		6	: rows[2] <= column[0];
		7	: rows[1] <= column[2];
		8	: rows[1] <= column[1];
		9	: rows[1] <= column[0];
		10	: rows[0] <= column[2]; // * alarm button
		11	: rows[0] <= column[0]; // # time button
	endcase
end
endmodule