type file;
app (file dot) dotproduct() {
    bash "dot.sh" 1 2 3 4 5 6 7 8 stdout=@dot;
}

file res <"completed.txt">;
res = dotproduct();
