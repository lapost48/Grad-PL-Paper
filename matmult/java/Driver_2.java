Matrix A = new Matrix(matrixA);
Matrix B = new Matrix(matrixB);

Vector[] cols = A.toCols();
Vector[] rows = B.toRows();

Matrix.initResult(rows.length, cols.length);

//                System.out.println("===> Generate and Run Calculations");
long start = System.currentTimeMillis();
for (int i = 0; i < rows.length; i++) {
    for(int j = 0; j < cols.length; j++) {
        new DotProduct(i, j, cols[j], rows[i]);
    }
    if (i % 10 == 0) {
//                        System.out.print("\r" + (i * 100 /
//                              (float) rows.length) + "%");
    }
}
//                System.out.println("\rRow 100.0%");

long end = System.currentTimeMillis();

total += end-start;
//System.out.println(Matrix.resultMatrix());
}
System.out.println(size);
times[l] = total / 100;
}

for(int i = 0; i < sizes.length; i++) {
System.out.println("Size: " + sizes[i] + " | Avg. Runtime: " +
(times[i] / 1000) + " | Total Runtime: " + (times[i] / 10));
}
}

}
