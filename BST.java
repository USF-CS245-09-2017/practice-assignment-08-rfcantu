public class BST<T>  {

    BSTNode root;

    public boolean find(Comparable item)
    {
        return find(root, item); // call private find
    }

    private boolean find(BSTNode node, Comparable item)
    {
        if (node == null) // base case
        {
            return false;
        }

        if (node.data.compareTo(item) == 0) // if the node we are at is what we're looking for
        {
            return true; // go down the right
        }

        else if (node.data.compareTo(item) > 0) // if the item is greater than our data
        {
            return find(node.right, item);
        }

        else // if the item is less than our data
        {
            return find(node.left, item); // go down the left
        }
    }

    public void insert(Comparable item)
    {
        root = insert(root, item); // call the private version of insert
    }

    private BSTNode insert(BSTNode node, Comparable item)
    {
        if (node == null) // if theres nothing there
        {
            BSTNode newNode = new BSTNode(item); // create a new node
            return newNode;
        }
        else if (node.data.compareTo(item) > 0) // if the value is less than
        {
            node.right = insert(node.right, item); // set it on the right
        }
        else // if the value is greater than
        {
            node.left = insert(node.left, item); // set it on the left
        }

        return node;
    }

    public void print()
    {
        print(root); // call private print
    }

    private void print(BSTNode node)
    {
        if (node != null)
        {
            print(node.getLeft()); // recursively go down the left side
            System.out.println(node.data); // print the current node
            print(node.getRight()); // recursively go down the right side
        }
    }

    public void delete(Comparable item)
    {
        root = delete(root, item); // call the private version of delete
    }

    private BSTNode delete(BSTNode node, Comparable item)
    {
        if (node == null) // if theres nothing there
            return null;

        if (node.data.compareTo(item) == 0) // if we have found the node
        {
            if (node.left == null) // if the left is empty
                return node.right;

            else if (node.right == null) // if the right is empty
                return node.left;

            else
            {
                if (node.right.left == null) // if the right has no left
                {
                    node.data = node.right.data; // get the right data
                    node.right = node.right.right; // make the right equal to the lower right
                    return node;
                }
                else
                {
                    node = (BSTNode) removeSmallest(node.right); // delete the sucessor
                    return node;
                }
            }
        }
        else if (node.data.compareTo(item) < 0)
            node.right = delete(node.right, item);  // travel down the right

        else
        {
            node.left = delete(node.left, item); // travel down the left
        }
        return null;
    }

    private Comparable removeSmallest(BSTNode node)
    {
        if (node.left.left == null) // if the lowest has nothing there
        {
            Comparable smallest = node.left.data; // get the data
            node.left = node.left.right; // assign the smallest to be the next one over
            return smallest; // return the data
        }

        else
        {
            return removeSmallest(node.left); // keep going down
        }
    }
}