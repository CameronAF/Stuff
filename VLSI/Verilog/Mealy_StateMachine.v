module mealy_1101(data_out, data_in, Clk, reset);
output data_out;
reg data_out;
input data_in, Clk, reset;
reg [1:0] pres_state, next_state;
parameter	S0 = 2'b00,
		S1 = 2'b01,
		S2 = 2'b10,
		S3 = 2'b11;

always@(posedge Clk or negedge reset)
begin
	if(reset == 1'b0)
		pres_state = S0;
	else
		pres_state = next_state;
end

always@(pres_state or data_in)
begin
	case(pres_state)
	S0:
		if(data_in == 1'b0)
			next_state = S0;
		else
			next_state = S1;
	S1:
		if(data_in == 1'b0)
			next_state = S0;
		else
			next_state = S2;
	S2:
		if(data_in == 1'b0)
			next_state = S3;
		else
			next_state = S2;
	S3:
		if(data_in == 1'b0)
			next_state = S0;
		else
			next_state = S0;
	endcase
end

always@(pres_state or data_in)
begin
	case(pres_state)
	S0:
		data_out = 1'b0;
	S1:
		data_out = 1'b0;
	S2:
		data_out = 1'b0;
	S3:
		if(data_in == 1'b0)
			data_out = 1'b0;
		else
			data_out = 1'b1;
	endcase
end
endmodule
