# crazy_date_calculations
A little crazy program that takes a String with a query to convert come date info and tries to interpret and answer it (approximately). This code assumes 365 days for a year and 30 days for a month. **This is experimental code.**

Currently, the only kind of input that gets answered is of the pattern:

`<x> [in] <period>`, e.g.: "quantos meses há em 8 semanas e 30 dias?".

* `<x>` can be: segundos, minutos, horas, dias, semanas, meses, anos (case-insensitive, can be singular or plural);
* `[in]` is optional. Means: existem em, há em, em, tem;
* `<period>` can be things like: 10 anos, 20 meses, 2 semanas e 15 dias...;
* All other text around it doesn't matter if it's not related to the core of the query or dates.
