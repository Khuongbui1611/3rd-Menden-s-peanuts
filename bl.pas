uses crt;
var
i,n,x,a,b,j:integer;
f1,f2:text;
C:array[1..100] of integer;
FUNCTION kt(k: longint): boolean;
 var j, d: integer;
 begin
   d:=0;
   kt:=false;
   for j:=1 to k do
      if k mod j=0 then inc(d);
   if d=2 then kt:=true;
 end;

Begin
assign(f1,'BT1.inp');
assign(f2,'BT1.out');
reset(f1);
rewrite(f2);
readln(f1,n);
a:=1;
b:=1;
i:=1;
repeat
  if kt(a) then writeln(f2,a);
  begin
  b:=b+a;
  a:=b-a;
  end;
until (i<n) and (a>n);


close(f1);
close(f2);
end.



