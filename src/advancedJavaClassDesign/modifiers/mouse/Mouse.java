
package advancedJavaClassDesign.modifiers.mouse;

import advancedJavaClassDesign.modifiers.cat.BigCat;

public class Mouse {
    public static void main(String[] args) {
        BigCat cat = new BigCat();
        System.out.println(cat.name);
        System.out.println(cat.hasFur); //nie kompiluje się bo tylko kod w podklasie lub w tym samym pakiecie ma dostęp do pól protected
        System.out.println(cat.hasPaws); //nie kompiluje się bo tylko kod w tym samym pakiecie ma dostęp do pól default
        System.out.println(cat.id); //nie kompiluje się bo id jest prywatne w klasie BigCat
    }
}
