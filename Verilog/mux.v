/*
module mux_2to1_dataflow (out, In, Sel);
output out;
input [1:0] In;
input Sel;

assign out = (In[0] && (~Sel)) || (In[1] && (Sel)); //dataflow
assign out = Sel ? In[1] : In[0]; //conditional
endmodule
*/

module mux_2to1_dataflow (out, In, Sel);
output out;
input [3:0] In;
input [1:0] Sel;

assign out = 	(In[0] & (~Sel[1]) & (~Sel[0])) | 
		(In[1] & (~Sel[1]) & (Sel[0])) | 
		(In[2] & (Sel[1]) & (~Sel[0])) | 
		(In[3] & (Sel[1]) & (Sel[0])); 

assign out = Sel[1] ? (Sel[0] ? In[3] : In[2]) : (Sel[0] ? In[1] : In[0]);
endmodule
