package tree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DeleteNodeBSTTest {

    @Test
    void deleteNode() {
        Integer[] array = {5,3,6,2,4,null,7};
        TreeNode root = Tree.constructTree(array);
        root = DeleteNodeBST.deleteNode(root, 3);
        System.out.println(Arrays.toString(TreeTraversal.preOrder(root).toArray()));
    }
}

