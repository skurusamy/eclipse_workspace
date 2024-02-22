class Path		//used for dijkstra testing
{
	Node parent;
	int weight;
	public Path(final int w, final Node p)
	{
		weight = w;
		parent = p;
	}
}