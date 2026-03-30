---
name: test-skill
description: "Validates skill loading by providing a minimal skill with reference files for testing the FileSystemSkillLoader. Use when verifying that the skill loader correctly parses frontmatter, filters empty references, and loads non-empty resource files."
---

## Purpose

This skill serves as a test fixture for validating the `FileSystemSkillLoader` implementation. It verifies that:

1. **Frontmatter parsing** — the loader correctly extracts `name` and `description` from YAML frontmatter.
2. **Empty reference filtering** — `references/empty.md` is excluded from loaded resources.
3. **Non-empty reference loading** — `references/full.md` is included in loaded resources.

## Reference Files

- [full.md](references/full.md) — contains test content that should be loaded as a skill resource.
- `references/empty.md` — intentionally empty; should be filtered out by the loader.