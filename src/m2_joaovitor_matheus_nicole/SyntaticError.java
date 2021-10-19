package m2_joaovitor_matheus_nicole;

public class SyntaticError extends AnalysisError
{
    public SyntaticError(String msg, int position)
	 {
        super(msg, position);
    }

    public SyntaticError(String msg)
    {
        super(msg);
    }
}
