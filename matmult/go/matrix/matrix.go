package matrix

type Matrix2d struct{
        Rows int
        Columns int
        Matrix []float64
}

func (a Matrix2d) Mult(b Matrix2d) Matrix2d{

        rows := a.Rows
        cols := b.Columns

        results := make([]float64, rows * cols)

        ch := make(chan float64, rows * cols)

        length := a.Columns
        var col []float64
        for i := 0; i < length; i++{
                col = a.getColumn(i)
                for j := 0; j < length; j++{
			go innerprod(col, b.Matrix[j*cols:j*cols+cols], i, j, ncols, results, ch)
                }
        }

	<-ch

        return Matrix2d{rows, cols, results}
}

func innerprod(col []float64, row []float64, r int, c int, ncols int, results []float64, ch chan float64){
	result := 0.0
	for k:=0; k< len(col); k++{
		result += col[k] * row[k]
	}
	results[r*ncols+c] = result
	ch<-1
}

func (m Matrix2d) getColumn(col int) []float64{
        result := make([]float64, m.Rows)
        cols := m.Columns
        for i :=0; i< m.Rows; i++{
                result[i] = m.Matrix[i*cols + col]
        }
        return result
}
