public class ChangeMaker {

	public static void main (String[] args) {

    /** VALIDATING PROGRAM */

    if ( args.length >= 2) {

        /** Checks for input less than or equal to zero */
        for (int i = 0; i < args.length; i++){

            int compare = Integer.parseInt( args[i] );

            if ( compare <= 0 ) {

                throw new IllegalArgumentException("BAD DATA");

            } else {

                /** Checks for duplicate input */
                for (int c = 0; c < args.length - 1; c++){

                    int contrast = Integer.parseInt( args[c] );

                    if ( i != c && compare == contrast ){

                        throw new IllegalArgumentException("BAD DATA");

                    }
                }
            }
        }

    } else {

        throw new IllegalArgumentException("BAD DATA");
    }



    /** INITIALIZING PROGRAM TUPLES AND ARRAYS */

    /** Number of rows */
   	int rowCount = args.length - 1;

    /** Number of columns and ultimate goal number */
	int amount = Integer.parseInt(args[rowCount]);

    /** Array of Rows */
	int[] rowArray = new int[rowCount];

    for (int i = 0; i < rowArray.length; i++) {

        rowArray[i] = Integer.parseInt(args[i]);

    }

    /** table Tuple is 2d array of change algorithm */
    /** goal is to allow a Tuple per cell */
    Tuple[][] table = new Tuple[rowCount][amount + 1];



    /** RUN PROGRAM */

    /** program files through variables row and column */
    for (int row = 0; row < rowCount; row++) {

        int current = rowArray[row];

        for (int column = 0; column < amount + 1; column++) {

            /** inputs tuple into cell */
            Tuple currentCell = table[row][column];
            /** leftover used to check if there is no remainder */
            int leftOver = column % current;
            /** remainder used to calculate how much needed to suffice amount */
			int remainder = column - current;

			if ( isFirstCell(row, column) ) {

                /** creates zero Tuple within current cell if its the first cell */
                table[row][column] = new Tuple(rowCount);

				} else if ( isFirstRow(row) ) {

                    if (remainder < 0 || leftOver != 0) {

                        /** inputs null if it impossible to make column amount with current cell coin amount */
						table[row][column] = null;

					} else {

                        /** creates Tuple within current cell */
                        table[row][column] = new Tuple(rowCount);
						table[row][column].setElement(row, 1);

						if (remainder > 0) {

                            /** adds table values to top row value */
							table[row][column] = table[row][column].add(table[row][remainder]);

						}
					}

                } else {

                    if (column == 0) {

                        /**initializes tuple cell with previous tuple cell*/
						table[row][column] = table[row-1][column];

					} else {

						if (remainder < 0) {

							table[row][column] = table[row-1][column];

						} else {

							table[row][column] = new Tuple(rowCount);
							table[row][column].setElement(row, 1);

							if (table[row][remainder] != null) {

								table[row][column] = table[row][column].add(table[row][remainder]);

                                //checks previous row calculations
								if (table[row-1][column] != null && table[row][column].sum() > table[row-1][column].sum()) {

									table[row][column] = table[row-1][column];

								} else {

									table[row][column] = table[row][column];

								}

							} else if (table[row-1][remainder] != null) {

								table[row][column] = table[row][column].add(table[row-1][remainder]);

							} else if (leftOver != 0) {

								if (table[row-1][column] != null) {

									table[row][column] = table[row-1][column];

								} else {

									table[row][column] = null;

								}
							}
						}
					}
                }
                /** OPTIONAL TO STRING METHOD */
                /** if you take out the /* then it will print array */

                /* if ( column == amount) {

                    System.out.println(table[row][column]);

                } else if ( row == ){

                    System.out.print(table[row][column] + "\t");

                } */
			}
		}



        /** PRINT ANSWER */

        /*checks bottom right corner Tuple for answer*/
        if ( table[rowCount - 1][amount] == null ){

            /*if tuple is null then there is no answer*/
            System.out.println("IMPOSSIBLE");

        } else {

            Tuple coinCount = table[rowCount - 1][amount];

            for (int i = 0; i < rowCount; i++) {

                System.out.println( coinCount.getElement(i) + " x " + rowArray[i] + " cent coins" );

            }

            System.out.println("total of " + coinCount.sum() + " coins");

        }

	}



    /** METHODS */

    /** method checks if cell is the first cell */
    public static boolean isFirstCell (int row, int column) {

        if (row != 0 || column != 0) {

            return false;

        } else {

            return true;

        }
    }

    /** method checks if cell is in the first row */
    public static boolean isFirstRow (int row) {

        if (row != 0) {

            return false;

        } else {

            return true;

        }
    }

}
