uses crt;
var i,j,n,d,t:integer;
    f1,f2:text;
    A:array[1..100]of integer;
Begin
assign(f1,'dayso.inp');
assign(f2,'dayso.out');
reset(f1);
rewrite(f2);
readln(f1,n);
for i:=1 to n do
 read(f1,A[i]);
for i:=1 to n do
 begin
  d:=0;
  for j:=i+1 to n-1 do
   if A[i]=A[j] then inc(d);
  if d=0 then inc(t);
  end;
writeln(f2,t);
for i:=1 to n do
 begin
  d:=0;
  for j:=i+1 to n-1 do
   if A[i]=A[j] then inc(d);
  if d=0 then write(f2,A[i],' ');
 end;
close(f1);
close(f2);
end.
