package by.epamtc.task2domparser.entity;



public class Document {
	@Override
	public String toString() {
		return "Document [tree=" + tree + "]";
	}

	private Element tree = new Element();

	public Element getTree() {
		return tree;
	}

	public void setTree(Element tree) {
		this.tree = tree;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tree == null) ? 0 : tree.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (tree == null) {
			if (other.tree != null)
				return false;
		} else if (!tree.equals(other.tree))
			return false;
		return true;
	}

	
}
