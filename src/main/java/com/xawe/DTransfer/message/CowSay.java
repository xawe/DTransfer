package com.xawe.dtransfer.message;

public class CowSay {

    public static String getMessage(AvatarEnum avatar){
        
        /*
		 * The message we want to print out
		 */
		String message = " Hello ModaFoca \n this execution was a sucess";
		
        StringBuilder sb = new StringBuilder();
		
		
		/*
		 * Here begins the formatted output of the tux.
		 * 
		 * Test on your own how it works. Trial & error is
		 * the best way.
		 */
        sb.append("  ");
        sb.append("\n");
		
		for (int i = 0; i <= message.length() + 1; i++) {		
            sb.append("_");
		}		
        sb.append("\n");        
				
		sb.append(" < " + message + " >\n");
		
		System.out.print("  ");
		for (int i = 0; i <= message.length() + 1; i++) {			
            sb.append("-");
		}		
        sb.append("\n");		
		
        sb.append(getAvatar(avatar));
        return sb.toString();
    }

    private static String getAvatar(AvatarEnum avatar){
        if(avatar.equals(AvatarEnum.TUX)){
            return getTux();
        }else if(avatar.equals(AvatarEnum.MIMOSA)){
            return getMimosa();
        }   
        return getMimosa();     
    }

    public static String getTux(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n");		
		
        sb.append("    \\\n");
		sb.append("     \\\n");
		sb.append("      \\\n");
		sb.append("         .--.\n");
		sb.append("        |o_o |\n");
		sb.append("        |:_/ |\n");
		sb.append("       //   \\ \\\n");
		sb.append("      (|     | )\n");
		sb.append("     /'\\_   _/`\\\n");
		sb.append("     \\___)=(___/\n");

        return sb.toString();
    }

    public static String getMimosa(){
        StringBuilder sb = new StringBuilder();

        sb.append("\\\n");
        sb.append(" \\ ^__^\n");
        sb.append("  \\(oo)\\_______\n");
        sb.append("   (__)\\       )\\/\\\n");
        sb.append("        ||----w |\n");
        sb.append("        ||     ||\n");        
        return sb.toString();
    }
}
