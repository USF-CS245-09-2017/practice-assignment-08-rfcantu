public class BSTNode<S> {

    BSTNode right;
    BSTNode left;
    Comparable data;

    public BSTNode(Comparable item)
    {
        this.right = null;
        this.left = null;
        this.data = item;
    }

    public BSTNode getLeft()
    {
        return this.left;
    }

    public BSTNode getRight()
    {
        return this.right;
    }

    public void setLeft(BSTNode node)
    {
        this.left = node;
    }

    public void setRight(BSTNode node)
    {
        this.right = right;
    }

}