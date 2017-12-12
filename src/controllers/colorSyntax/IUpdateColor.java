package controllers.colorSyntax;

import java.awt.Color;

/**
 *
 * @author Daniel Martinez
 */
interface IUpdateColor 
{
    void updateColorText( int offset,  int length,  Color c,  boolean bold );
}
