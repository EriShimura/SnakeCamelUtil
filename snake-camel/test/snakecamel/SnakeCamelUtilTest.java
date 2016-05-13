package snakecamel;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class SnakeCamelUtilTest {

	//////////////////////////////
	//  snakeToCamelcaseのtest
	//////////////////////////////
	
	@Test
	public void 通常のスネークケースを渡した場合()
		{ assertThat(SnakeCamelUtil.snakeToCamelcase("abc_def_ghi"), is("AbcDefGhi")); }
	
	@Test
	public void 下線からはじまる文字列を渡した場合()
		{ assertThat(SnakeCamelUtil.snakeToCamelcase("_abc_def"), is("AbcDef")); }
	
	@Test
	public void 下線でおわる文字列を渡した場合()
		{ assertThat(SnakeCamelUtil.snakeToCamelcase("abc_def_"), is("AbcDef")); }
	
	@Test
	public void キャメルケースを渡した場合()
		{ assertThat(SnakeCamelUtil.snakeToCamelcase("AbcDef"), is("Abcdef")); }
	
	@Test
	public void スネークでもキャメルでもない文字列を渡した場合_snake()
		{ assertThat(SnakeCamelUtil.snakeToCamelcase("abcdef"), is("Abcdef")); }
	
	@Test
	public void 余分な空白が文字列のはじめに含まれている場合()
		{ assertThat(SnakeCamelUtil.snakeToCamelcase(" abc_def"), is("AbcDef")); }
	
	@Test
	public void 余分な空白が文字列の途中に含まれている場合()
		{ assertThat(SnakeCamelUtil.snakeToCamelcase("abc_d ef"), is("AbcDef")); }
	
	///////////////////////////////
	//  camelToSnakecaseのtest
	///////////////////////////////
	
	@Test
	public void 通常のキャメルケースを渡した場合()
		{ assertThat(SnakeCamelUtil.camelToSnakecase("AbcDefGhi"), is("abc_def_ghi")); }
	
	@Test
	public void はじめが小文字の文字列を渡した場合()
		{ assertThat(SnakeCamelUtil.camelToSnakecase("abcDefGhi"), is("abc_def_ghi")); }
	
	@Test
	public void 最後が大文字の文字列を渡した場合()
		{ assertThat(SnakeCamelUtil.camelToSnakecase("bcDefGhiA"), is("bc_def_ghi_a")); }
	
	@Test
	public void スネークでもキャメルでもない文字列を渡した場合_camel()
		{ assertThat(SnakeCamelUtil.camelToSnakecase("abcdef"), is("abcdef")); }
	
	@Test
	public void 余分な空白がはじめに含まれている文字列を渡した場合()
		{ assertThat(SnakeCamelUtil.camelToSnakecase(" AbcDef"), is("abc_def")); }
	
	@Test
	public void 余分な空白が途中に含まれている文字列を渡した場合()
		{ assertThat(SnakeCamelUtil.camelToSnakecase("Abc De f"), is("abc_def")); }

}
	
	